package de.allianz.training.permissions;

public enum Permissions {

        TODO_READ("todos:read"),
        TODO_WRITE("todo:write"),
        TODO_CREATE("todo:create"),
        TODO_UPDATE("todo:update"),
        TODO_DELETE("todo:delete"),
        USER_READ("users:read"),
        USER_WRITE("users:write");


    private final String permission;

    Permissions(String permission) {this.permission = permission;}

    public String getPermission() {return permission;}
}
