package br.com.conselhodeamigo.website.domain.model;

import java.util.Optional;

public enum Type {

    LOVE,
    WORK,
    MONEY;

    public static Optional<Type> of(String type) {
        if (type == null) {
            return Optional.empty();
        }

        switch (type) {
            case "LOVE": return Optional.of(LOVE);
            case "WORK": return Optional.of(WORK);
            case "MONEY": return Optional.of(MONEY);
            default: return Optional.empty();
        }
    }

    public static Type defaultType() {
        return LOVE;
    }
}

