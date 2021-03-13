package com.raptor.optionals;

import com.raptor.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Documented;
import java.util.Optional;

public class OptionalTests {

    @Test
    @DisplayName("using_of")
    public void generateNPEWhenOptionalValueIsNull() {
        User user = null;
        Assertions.assertThrows(NullPointerException.class, () -> Optional.of(user));

        return;
    }

    @Test
    @DisplayName("using_isPresent")
    public void returnFalseWhenOptionalIsEmpty() {
        Optional<User> user = Optional.empty();
        /**
         * returns boolean if Optional is not empty,
         * without any action as a result.
         * <em>compare with ifPresent...</em>
         */
        Assertions.assertFalse(user.isPresent());

        return;
    }

    @Test
    @DisplayName("using_orElse")
    public void userTypeOptionalValueShouldBeReturnedWhenNonEmpty() {
        final User __user = new User();
        Assertions.assertEquals( __user , Optional.of(__user).orElse(new User()));

        return;
    }

    @Test
    public void nullPointerExceptionNotThrownWhenNullableUsedForNullValue() {
        final User user = null;
        Assertions.assertFalse(Optional.ofNullable(user).isPresent());

        return;
    }

    @Test
    @DisplayName("ifPresent_action")
    public void printUserDetailsIfAndOnlyIfNonEmpty() {
        final User user = new User();
        user.setFirstName("kuldip");
        user.setLastName("bajwa");
        /* --- check if Option is not empty then execute action --- */
        Optional.of(user).ifPresent((u) -> System.out.print(u));
        Assertions.assertEquals(user, Optional.of(user).get(), "user not found");

        return;
    }

}