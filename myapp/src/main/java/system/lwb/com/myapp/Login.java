package system.lwb.com.myapp;

public class Login {

    /**
     * token_type : Bearer
     * expires_in : 1296000
     * access_token : eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6ImQ2NjViY2E1NjFhNmVkZmY5ZWM5NGI2NmQ5YjZiYTFjYWZiZWZkZTE4MThiOWE1ZTA3OGYyNTAwYjg4MjUzOGZmY2ZmMmJiNmZkODA0OThkIn0.eyJhdWQiOiIyIiwianRpIjoiZDY2NWJjYTU2MWE2ZWRmZjllYzk0YjY2ZDliNmJhMWNhZmJlZmRlMTgxOGI5YTVlMDc4ZjI1MDBiODgyNTM4ZmZjZmYyYmI2ZmQ4MDQ5OGQiLCJpYXQiOjE1MDU0NTY3NTUsIm5iZiI6MTUwNTQ1Njc1NSwiZXhwIjoxNTA2NzUyNzU1LCJzdWIiOiI2NSIsInNjb3BlcyI6W119.Y8iA4oh32pr38TB5vvG8Gh1R6AxzFc0Tj6uExwRMCe-GMqi5BX72Gw1uYcVFQudtQKMjwx1VEXgIYuiWE1Ndyedm5wajFAjfMH1h65lN48T_UpxTzvNbl9W81z1lGv3H1X3L8jJyNniZI2XBl3D_7QwoW-m9-Trd2daZ6q_Yj6VOK5mtHHXO7OQfekvytG7G4W0OyqrHUhrr_YewEjzFY165xpXh7GvAvQFWAAddxUHiWEuVoQH5JJx4YHwOqfdLYgLBYHTop-Ov_hX7xbxQ2yNXbnFPIgcIRyF1XBqvK8Y9ry0msIzzxNx7ObsNE0GnGyH_j3opbvMLHkcavQcuzKwcGimkARXXi1_kG3FfHeeA4zs8A4urHEUbDhFSycX1_lCKYw0MwNi8RYml-eUS5ysightvDztfXbPSaFV-RiIPQYo1sohteR6RSNb2SMwfCBgJdc3M2ClJho5TG-Ho6SFyrhiq51PJeRtmhdAEiBZCXVDYkcc8yH7PbtZ5vcgto0p5iofjPsyksvSjnd01N99u-OsdwTmino-fOJFetw-QQ6PlaELThO0ow9vnkACaj3oS7gsdq5uDQWoU0mgazl5cOtEbY5nriaqmUHM20xckENioXYWbij7Vebh7HpztyjnD41TTxalT5oXtOGDKTPNqcP-XnbtkXOeu5Qh9M1A
     * refresh_token : def50200e1d8957191c1f625dcf960b6bc6e45644d19e3a5f7a94f5ffddeb5273bf1963ab6c8ca834f63dca2fccb146451262c4ca0185f8eb891de6dbcd10054b9c6b4724fa6c2294b078d8cea0cc121f469079a18d2d6cee90516cdccd92d2e1ee2cbeb46ac6ac709f124da657bcbb800a876be4411c4101e90382ab1461a8ddca8f74673861e9aaae03eb79fe05ea265a3a4480c85fadb2faa791506adaff519145081e410ba066e223d3eac3e953e65ddf2fe48849f4f4f691144523b0c9f8a8acd8373f4066414a193cc697bb5d3fc8d69238b67c3c6d052fe68ff152455e29b69cbbe6cbd02c74dfcc7d48d240f9c1a8996732f52fc6523a6b7fa0ddf92d0eaa00b416b6ee456e35f9ca4a6e9631f5d259c69d04781db3d7ec86c8dbcb13d0cb2b2d2ce7671f6dbf3a25563029d60d7677074d7be825736f370471b7491bb6b08f2fbecbb220f47b497484566f6c06312c88b70a6899dfff9c71459513d
     */

    private String token_type;

    @Override
    public String toString() {
        return "Login{" +
                "token_type='" + token_type + '\'' +
                ", expires_in=" + expires_in +
                ", access_token='" + access_token + '\'' +
                ", refresh_token='" + refresh_token + '\'' +
                '}';
    }

    private int expires_in;
    private String access_token;
    private String refresh_token;

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }
}
