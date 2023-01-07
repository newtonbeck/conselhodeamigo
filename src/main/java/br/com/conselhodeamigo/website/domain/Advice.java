package br.com.conselhodeamigo.website.domain;

import java.time.Clock;
import java.time.Instant;

public class Advice {

    public enum Type {
        LOVE, WORK, MONEY;
    }

    private String content;

    private Instant createdAt;

    private String author;

    private Type type;

    public Advice(String content, String author, Type type) {
        this(content, author, type, Clock.systemUTC());
    }

    public Advice(String content, String author, Type type, Clock clock) {
        this.content = content;
        this.author = author;
        this.type = type;
        this.createdAt = Instant.now(clock);
    }

    public String getContent() {
        return content;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public String getAuthor() {
        return author;
    }

    public Type getType() {
        return type;
    }
}
