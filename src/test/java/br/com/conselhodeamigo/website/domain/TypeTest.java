package br.com.conselhodeamigo.website.domain;

import br.com.conselhodeamigo.website.domain.model.Type;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TypeTest {

    @Test
    public void a_LOVE_string_should_be_converted_to_type() {
        assertEquals(Type.LOVE, Type.of("LOVE").get());
    }

    @Test
    public void a_MONEY_string_should_be_converted_to_type() {
        assertEquals(Type.MONEY, Type.of("MONEY").get());
    }

    @Test
    public void a_WORK_string_should_be_converted_to_type() {
        assertEquals(Type.WORK, Type.of("WORK").get());
    }

    @Test
    public void a_non_existent_type_as_string_should_be_converted_to_type() {
        assertEquals(Optional.empty(), Type.of("RANDOM"));
    }

    @Test
    public void a_null_string_should_be_converted_to_type() {
        assertEquals(Optional.empty(), Type.of(null));
    }

    @Test
    public void love_should_be_the_default_type() {
        assertEquals(Type.LOVE, Type.defaultType());
    }

}
