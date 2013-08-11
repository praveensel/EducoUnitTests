package com.educo.tests.Templates;

public enum BrowserType {
    FIREFOX("firefox"),
    CHROME("chrome"),
    IE("ie"),
    SAFARI("safari"),
    OPERA("opera"),
    GHOSTDRIVER("ghostdriver"),
    REMOTE("remote"),
    HTMLUNIT("htmlunit");

    private final String browser;

    BrowserType(String browser) {
        this.browser = getBrowser();
    }

    public String getBrowser() {
        return browser;
    }
}

