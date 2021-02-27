package com.raptor.functional;

import com.raptor.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class OptionalTests {

    @Test
    public void generateNPEWhenOptionalValueIsNull() {
        User user = null;
        Assertions.assertThrows(NullPointerException.class, () -> Optional.of(user));

        return;
    }

    @Test
    public void returnFalseWhenOptionalIsEmpty() {
        Optional<User> user = Optional.empty();
        Assertions.assertFalse(user.isPresent());

        return;
    }

    @Test
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

}
