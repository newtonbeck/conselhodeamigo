package br.com.conselhodeamigo.website.domain.usecase;

import br.com.conselhodeamigo.website.domain.model.Advice;
import br.com.conselhodeamigo.website.domain.model.Advices;
import br.com.conselhodeamigo.website.domain.model.Type;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllAdvicesPerTypeUseCase {

    private final Advices advices;

    public GetAllAdvicesPerTypeUseCase(Advices advices) {
        this.advices = advices;
    }

    public interface Callback {

        void invalidType(String invalidType, Type defaultType);

        void noAdvicesWereFoundFor(Type type);

        void advicesFound(List<Advice> advicesFound);

    }

    public static class Input {

        private final String type;

        public Input(String type) {
            this.type = type;
        }

        public String getType() {
            if (type == null) {
                return null;
            }
            return type.toUpperCase();
        }
    }

    public void getAllAdvicesPerType(
            Input input,
            Callback callback
    ) {
        Type.of(input.getType()).ifPresentOrElse(
                (type) -> {
                    List<Advice> advicesFound = advices.getAllPerType(type);

                    if (advicesFound.isEmpty()) {
                        callback.noAdvicesWereFoundFor(type);
                    } else {
                        callback.advicesFound(advicesFound);
                    }
                },
                () -> callback.invalidType(input.type, Type.defaultType())
        );
    }
}
