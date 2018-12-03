package com.ray3k.dreamsofpinkui.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.ray3k.dreamsofpinkui.Core;

public class DesktopLauncher {

    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = 432;
        config.height = 774;
        new LwjglApplication(new Core(), config);
    }
}
