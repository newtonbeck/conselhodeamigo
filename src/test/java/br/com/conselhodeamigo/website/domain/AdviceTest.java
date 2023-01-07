package br.com.conselhodeamigo.website.domain;

import org.junit.jupiter.api.Test;

import java.time.*;

import static org.junit.jupiter.api.Assertions.*;

class AdviceTest {

    @Test
    public void a_new_advice_should_contain_the_provided_content() {
        Advice advice = new Advice("Most decisions are reversible", "Mr Nobody", Advice.Type.WORK);
        assertEquals("Most decisions are reversible", advice.getContent());
    }

    @Test
    public void a_new_advice_should_contain_the_provided_author() {
        Advice advice = new Advice("Most decisions are reversible", "Mr Nobody", Advice.Type.WORK);
        assertEquals("Mr Nobody", advice.getAuthor());
    }

    @Test
    public void a_new_advice_should_contain_the_provided_type() {
        Advice advice = new Advice("Most decisions are reversible", "Mr Nobody", Advice.Type.WORK);
        assertEquals(Advice.Type.WORK, advice.getType());
    }

    @Test
    public void a_new_advice_should_know_when_it_was_created() {
        ZoneOffset utcZoneOffset = ZoneOffset.UTC;
        ZoneId utcZoneId = ZoneId.from(utcZoneOffset);

        Instant fixedInstant = LocalDateTime
                .of(2023, 01, 07, 10, 30, 25)
                .toInstant(utcZoneOffset);
        Clock fixedClock = Clock.fixed(fixedInstant, utcZoneId);

        Advice advice = new Advice("Most decisions are reversible", "Mr Nobody", Advice.Type.WORK, fixedClock);

        assertEquals(fixedInstant, advice.getCreatedAt());
    }

}