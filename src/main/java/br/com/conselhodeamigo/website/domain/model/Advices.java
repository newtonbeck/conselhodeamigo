package br.com.conselhodeamigo.website.domain.model;

import java.util.List;

public interface Advices {
    List<Advice> getAllPerType(Type type);

}
