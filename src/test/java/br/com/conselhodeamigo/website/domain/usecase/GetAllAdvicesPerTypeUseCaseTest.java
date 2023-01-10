package br.com.conselhodeamigo.website.domain.usecase;

import br.com.conselhodeamigo.website.domain.model.Advice;
import br.com.conselhodeamigo.website.domain.model.Advices;
import br.com.conselhodeamigo.website.domain.model.Type;
import br.com.conselhodeamigo.website.infra.db.InMemoryAdvices;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class GetAllAdvicesPerTypeUseCaseTest {

    @Test
    public void it_should_invoke_callbacks_invalid_type_when_type_is_null() {
        Advices advices = new InMemoryAdvices();
        GetAllAdvicesPerTypeUseCase.Callback callback = mock(GetAllAdvicesPerTypeUseCase.Callback.class);
        GetAllAdvicesPerTypeUseCase useCase = new GetAllAdvicesPerTypeUseCase(advices);

        useCase.getAllAdvicesPerType(
                new GetAllAdvicesPerTypeUseCase.Input(null),
                callback
        );

        verify(callback, only()).invalidType(null, Type.defaultType());
    }

    @Test
    public void it_should_invoke_callbacks_invalid_type_when_type_is_invalid() {
        Advices advices = new InMemoryAdvices();
        GetAllAdvicesPerTypeUseCase.Callback callback = mock(GetAllAdvicesPerTypeUseCase.Callback.class);
        GetAllAdvicesPerTypeUseCase useCase = new GetAllAdvicesPerTypeUseCase(advices);

        useCase.getAllAdvicesPerType(
                new GetAllAdvicesPerTypeUseCase.Input("unknown"),
                callback
        );

        verify(callback, only()).invalidType("unknown", Type.defaultType());
    }

    @Test
    public void it_should_invoke_callbacks_no_advices_were_found_when_advices_list_is_empty() {
        Advices advices = new InMemoryAdvices();
        GetAllAdvicesPerTypeUseCase.Callback callback = mock(GetAllAdvicesPerTypeUseCase.Callback.class);
        GetAllAdvicesPerTypeUseCase useCase = new GetAllAdvicesPerTypeUseCase(advices);

        useCase.getAllAdvicesPerType(
                new GetAllAdvicesPerTypeUseCase.Input("money"),
                callback
        );

        verify(callback, only()).noAdvicesWereFoundFor(Type.MONEY);
    }

    @Test
    public void it_should_invoke_callbacks_advices_found_when_advices_list_is_not_empty() {
        List<Advice> advices = Arrays.asList(
                new Advice("Work-Life Balance", "Mr Burnout", Type.WORK),
                new Advice("Ask For Help", "Mr Know it All", Type.WORK)
        );
        Advices inMemoryAdvices = new InMemoryAdvices(advices);
        GetAllAdvicesPerTypeUseCase.Callback callback = mock(GetAllAdvicesPerTypeUseCase.Callback.class);
        GetAllAdvicesPerTypeUseCase useCase = new GetAllAdvicesPerTypeUseCase(inMemoryAdvices);

        useCase.getAllAdvicesPerType(
                new GetAllAdvicesPerTypeUseCase.Input("work"),
                callback
        );

        verify(callback, only()).advicesFound(advices);
    }

}