package com.openbravo.pos.forms;

public interface AppUserView {

    public static final String ACTION_TASKNAME = "taskname";

    // Acciones de la aplicacion

        public AppUser getUser(); // Usuario logado

    public void showTask(String sTaskClass);

    public void executeTask(String sTaskClass);
}
