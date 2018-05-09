package com.gl.sdp.pricecoin.bl.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = "Unauthorized access")
public class UnauthorizedUserPriceCoinException extends PriceCoinException {
}
