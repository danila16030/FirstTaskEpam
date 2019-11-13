package com.epam.firsttask.action.load;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LineValidationAction {
    public boolean pointComplianceCheck(String line, Pattern p) {
        Matcher m = p.matcher(line);
        return m.matches();
    }

    public  boolean circleComplianceCheck(String line, Pattern p) {
        Matcher m = p.matcher(line);
        return m.matches();
    }

    public boolean quadrangleComplianceCheck(String line, Pattern p) {
        Matcher m = p.matcher(line);
        return m.matches();
    }

}
