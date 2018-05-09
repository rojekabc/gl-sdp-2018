package com.gl.sdp.pricecoin.sl;

import org.springframework.stereotype.Component;

@Component
public class DataNeutralizerComponent {
    public String neutralize(String string) {
        return string == null ? null : string.trim();
    }
}
