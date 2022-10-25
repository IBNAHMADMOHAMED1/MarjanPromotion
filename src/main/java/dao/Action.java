package dao;

import service.JpaService;

import java.lang.reflect.Type;

public class Action {
    private static String entityName;
    private static String[] data;
    private static final JpaService jpaService = JpaService.getInstance();

    public static String getEntityName() {
        return entityName;
    }
    public static void setEntityName(String table) {
        Action.entityName = table;
    }




}
