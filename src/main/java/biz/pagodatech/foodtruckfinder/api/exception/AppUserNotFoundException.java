package biz.pagodatech.foodtruckfinder.api.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class AppUserNotFoundException extends RuntimeException{
    private final String username;
}
