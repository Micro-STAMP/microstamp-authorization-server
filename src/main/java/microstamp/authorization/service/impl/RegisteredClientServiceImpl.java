package microstamp.authorization.service.impl;

import microstamp.authorization.service.RegisteredClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RegisteredClientServiceImpl implements RegisteredClientService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<String> getClientBaseUris() {
        String sql = "SELECT redirect_uris FROM oauth2_registered_client";
        List<String> redirectUris = jdbcTemplate.queryForList(sql, String.class);

        return redirectUris.stream()
                .map(this::extractBaseUri)
                .collect(Collectors.toList());
    }

    private String extractBaseUri(String redirectUri) {
        try {
            URI uri = new URI(redirectUri);
            return uri.getScheme() + "://" + uri.getHost() + ":" + uri.getPort();
        } catch(URISyntaxException ex) {
            return "";
        }
    }
}
