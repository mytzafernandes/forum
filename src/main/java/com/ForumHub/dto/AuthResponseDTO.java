

package com.forumhub.dto;


public class AuthResponseDTO {
    private String token;
    private String tipoToken;

    public AuthResponseDTO(String token, String tipoToken) {
        this.token = token;
        this.tipoToken = tipoToken;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTipoToken() {
        return tipoToken;
    }

    public void setTipoToken(String tipoToken) {
        this.tipoToken = tipoToken;
    }
}
