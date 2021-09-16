package com.library.ui.constant;

public enum LanguagesListEnum {
    RUSSIAN(1),
    UZBEK(2),
    ENGLISH(3),
    POLAND(4),
    KAZAKH(5),
    UKRAINIAN(6),
    CHINESE(7),
    FRENCH(8),
    ITALIAN(9),
    TURKISH(10);

    private final Integer language;

    LanguagesListEnum(Integer value) {
        this.language = value;
    }

    public Integer getLanguage() {
        return language;
    }
}
