package org.wordpress.android.models;

import java.util.ArrayList;

public class JetpackSettingsModel {
    public long localTableId;
    public boolean monitorActive;
    public boolean emailNotifications;
    public boolean wpNotifications;
    public boolean jetpackProtectEnabled;
    public ArrayList<String> jetpackProtectWhitelist;

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof JetpackSettingsModel)) return false;
        JetpackSettingsModel otherModel = (JetpackSettingsModel) other;
        return monitorActive == otherModel.monitorActive &&
                emailNotifications == otherModel.emailNotifications &&
                wpNotifications == otherModel.wpNotifications &&
                jetpackProtectEnabled == otherModel.jetpackProtectEnabled &&
                whitelistMatches(otherModel.jetpackProtectWhitelist);
    }

    public boolean whitelistMatches(ArrayList<String> otherWhitelist) {
        if (jetpackProtectWhitelist == null) {
            return otherWhitelist == null;
        } else if (otherWhitelist == null) {
            return false;
        }

        return jetpackProtectWhitelist.equals(otherWhitelist);
    }
}
