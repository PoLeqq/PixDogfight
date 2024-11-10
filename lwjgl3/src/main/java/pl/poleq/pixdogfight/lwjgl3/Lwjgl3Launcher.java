package pl.poleq.pixdogfight.lwjgl3;

import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import pl.poleq.pixdogfight.Main;

/** Launches the desktop (LWJGL3) application. */
public class Lwjgl3Launcher {
    public static void main(String[] args) {
        if (StartupHelper.startNewJvmIfRequired()) return; // This handles macOS support and helps on Windows.
        createApplication();
    }

    private static Lwjgl3Application createApplication() {
        return new Lwjgl3Application(new Main(), getDefaultConfiguration());
    }

    private static Lwjgl3ApplicationConfiguration getDefaultConfiguration() {
        Lwjgl3ApplicationConfiguration configuration = new Lwjgl3ApplicationConfiguration();
        configuration.setTitle("PixDogfight");
        //// Vsync limits the frames per second to what your hardware can display, and helps eliminate
        //// screen tearing. This setting doesn't always work on Linux, so the line after is a safeguard.
        configuration.useVsync(true);
        //// Limits FPS to the refresh rate of the currently active monitor, plus 1 to try to match fractional
        //// refresh rates. The Vsync setting above should limit the actual FPS to match the monitor.
        configuration.setForegroundFPS(Lwjgl3ApplicationConfiguration.getDisplayMode().refreshRate + 1);
        //// If you remove the above line and set Vsync to false, you can get unlimited FPS, which can be
        //// useful for testing performance, but can also be very stressful to some hardware.
        //// You may also need to configure GPU drivers to fully disable Vsync; this can cause screen tearing.
//        configuration.setWindowedMode(640, 480);
//        configuration.setForegroundFPS(10);
        setFullscreenOnSecondMonitor(configuration);

        //// You can change these files; they are in lwjgl3/src/main/resources/ .
        configuration.setWindowIcon("libgdx128.png", "libgdx64.png", "libgdx32.png", "libgdx16.png");
        return configuration;
    }

    public static void setFullscreenOnSecondMonitor(Lwjgl3ApplicationConfiguration configuration) {
        Graphics.Monitor[] monitors = Lwjgl3ApplicationConfiguration.getMonitors();

        if (monitors.length > 1) {
            // Set the second monitor (index 1)
            Graphics.Monitor secondMonitor = monitors[1];
            Graphics.DisplayMode displayMode = Lwjgl3ApplicationConfiguration.getDisplayMode(secondMonitor);

            // Apply fullscreen mode to the second monitor
            configuration.setFullscreenMode(displayMode);
        } else {
            System.out.println("Second monitor not found. Defaulting to primary monitor.");
            // Fallback to primary monitor's fullscreen
            configuration.setFullscreenMode(Lwjgl3ApplicationConfiguration.getDisplayMode(Lwjgl3ApplicationConfiguration.getPrimaryMonitor()));
        }
    }
}
