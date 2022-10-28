package by.it_academy.bootcamp.users.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Objects;

@AutoConfigureMockMvc
@SpringBootTest
class UserControllerImplTest {

    @Autowired
    private MockMvc mockMvc;

    @ParameterizedTest
    @CsvFileSource(resources = "/user_failed.csv", delimiter = ';', numLinesToSkip = 1)
    @Order(1)
    void apiV1UserPostFailed(String email, String name, String surname, String patronymic, String role) throws Exception {
        String user = getJsonUser(email, name, surname, patronymic, role);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/user").content(user).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/users.csv", delimiter = ';', numLinesToSkip = 1)
    @Order(2)
    void apiV1UserPost(String email, String name, String surname, String patronymic, String role) throws Exception {
        String user = getJsonUser(email, name, surname, patronymic, role);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/user").content(user).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(201));
    }

    @Test
    @Order(3)
    void apiV1UserGet() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/user"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(getContent()));
    }

    private static String getJsonUser(String email, String name, String surname, String patronymic, String role) {
        StringBuilder builder = new StringBuilder("{\n");

        appendJsonLine(builder , getJsonLine("email", email));
        appendJsonLine(builder , getJsonLine("name", name));
        appendJsonLine(builder , getJsonLine("surname", surname));
        appendJsonLine(builder , getJsonLine("patronymic", patronymic));
        appendJsonLine(builder , getJsonLine("role", role));
        builder.append("\n}");

        return builder.toString();
    }

    private static String getJsonLine(String name, String value) {
        if (!Objects.isNull(value)) {
            return "\t\"" + name + "\":\"" + value + "\"";
        }

        return null;
    }

    private static void appendJsonLine(StringBuilder stringBuilder, String line) {
        if (!Objects.isNull(line)) {
            if (stringBuilder.charAt(stringBuilder.length() - 1) == '"'){
                stringBuilder.append(",\n");
            }

            stringBuilder.append(line);
        }

    }

    private static String getContent() {
        return "{\n" +
                "    \"page\": 0,\n" +
                "    \"size\": 10,\n" +
                "    \"total_pages\": 1,\n" +
                "    \"total_elements\": 5,\n" +
                "    \"first\": true,\n" +
                "    \"number_of_elements\": 5,\n" +
                "    \"last\": true,\n" +
                "    \"content\": [\n" +
                "        {\n" +
                "            \"full_name\": \"Alexovich Alex Alexov\",\n" +
                "            \"email\": \"alex@mail.ru\",\n" +
                "            \"role\": \"Customer User\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"full_name\": \"Darieva Daria Darievna\",\n" +
                "            \"email\": \"Dasha@daria.com\",\n" +
                "            \"role\": \"Administrator\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"full_name\": \"Ilianovich Ilia Iliin\",\n" +
                "            \"email\": \"ilia@mail.ru\",\n" +
                "            \"role\": \"Secure API User\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"full_name\": \"ivanov ivan Ivanovich\",\n" +
                "            \"email\": \"ivan@mail.ru\",\n" +
                "            \"role\": \"Administrator\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"full_name\": \"siarheevich sirhey siarheev\",\n" +
                "            \"email\": \"siarhey@mail.ru\",\n" +
                "            \"role\": \"Sale User\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
    }
}