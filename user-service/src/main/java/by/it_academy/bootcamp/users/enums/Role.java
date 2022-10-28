package by.it_academy.bootcamp.users.enums;

public enum Role {

    ADMINISTRATOR("Administrator"),
    SALE_USER("Sale User"),

    CUSTOMER_USER("Customer User"),
    SECURE_API_USER("Secure API User");

    private final String name;

    Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Role getRole(String name) {
        switch (name) {
            case "Administrator" :
                return Role.ADMINISTRATOR;
            case "Sale User":
                return Role.SALE_USER;
            case "Customer User":
                return Role.CUSTOMER_USER;
            case "Secure API User":
                return Role.SECURE_API_USER;
            default: throw new IllegalArgumentException("Unsupported role");
        }
    }
}
