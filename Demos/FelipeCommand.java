
public enum FelipeCommand {
    KEY_LEFT("Left"), KEY_RIGHT("Right"), MOUSE_CLICK("Click"), BUTTON_PRESS("Button");

    private String friendlyName;

    FelipeCommand(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    public String toString() {
        return friendlyName;
    }
}
