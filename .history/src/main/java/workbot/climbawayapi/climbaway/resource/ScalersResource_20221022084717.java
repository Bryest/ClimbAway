package workbot.climbawayapi.climbaway.resource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScalersResource {

    private Long id;

    private String first_name;

    private String last_name;

    private String password;

    private String city;

    private String district;

    private String address;

    private String phone;

    private String logo_url;
}
