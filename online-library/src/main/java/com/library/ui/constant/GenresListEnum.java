package com.library.ui.constant;

import java.util.Locale;

public enum GenresListEnum {
    LITERARY_FICTION(1),
    MYSTERY(2),
    THRILLER(3),
    HORROR(4),
    HISTORICAL(5),
    ROMANCE(6),
    WESTERN(7),
    BILDUNGROSMAN(8),
    SPECULATIVE_FICTION(9),
    SCIENCE_FICTION(10),
    FANTASY(11),
    DYSTOPIAN(12),
    MAGICAL_REALISM(13),
    REALIST_LITERATURE(14);

    private final Integer genre;

    GenresListEnum(Integer value) {
        this.genre = value;
    }

    public Integer getGenre() {
        return genre;
    }

}
