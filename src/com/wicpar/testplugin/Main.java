package com.wicpar.testplugin;


import com.wicpar.sinkingsimulator2base.mech.Dependency;
import com.wicpar.sinkingsimulator2base.mech.IBaseMod;
import com.wicpar.sinkingsimulator2base.utils.Logger;
import com.wicpar.sinkingsimulator2base.utils.output.IOut;

/**
 * Created by Frederic on 03/09/2015.
 */
public class Main implements IBaseMod {

    private final Dependency[] dependencies = new Dependency[]{new Dependency(Dependency.Type.Absolute, "")};
    private final String ID = "ConsoleWindow";
    private Window window;

    /**
     * the dependencies of the module. the effects are specified in @Dependency.java
     *
     * @return the list of dependencies of the Module
     */
    @Override
    public Dependency[] getDependencies() {
        return dependencies;
    }

    /**
     * The ID of the module. It has to be unique.
     *
     * @return the ID of the module
     */
    @Override
    public String getID() {
        return ID;
    }

    /**
     * Called To initialize the module.
     */
    @Override
    public boolean Load() {
        window = Window.main();
        Logger.addLog(window);
        return true;
    }
}
