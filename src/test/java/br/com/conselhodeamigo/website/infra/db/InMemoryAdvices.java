package br.com.conselhodeamigo.website.infra.db;

import br.com.conselhodeamigo.website.domain.model.Advice;
import br.com.conselhodeamigo.website.domain.model.Advices;
import br.com.conselhodeamigo.website.domain.model.Type;

import java.util.*;

public class InMemoryAdvices implements Advices {

    private Map<Type, List<Advice>> advices = new HashMap<>();

    public InMemoryAdvices(Advice... advices) {
        this(Arrays.asList(advices));
    }
    public InMemoryAdvices(List<Advice> advices) {
        advices.forEach((advice) -> {
            List<Advice> advicesOfType = this.advices.getOrDefault(
                    advice.getType(),
                    new ArrayList<>()
            );
            advicesOfType.add(advice);
            this.advices.put(advice.getType(), advicesOfType);
        });
    }

    @Override
    public List<Advice> getAllPerType(Type type) {
        return advices.getOrDefault(type, Collections.emptyList());
    }

}
