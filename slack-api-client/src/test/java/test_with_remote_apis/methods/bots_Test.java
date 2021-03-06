package test_with_remote_apis.methods;

import com.slack.api.Slack;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.response.bots.BotsInfoResponse;
import com.slack.api.model.User;
import config.Constants;
import config.SlackTestConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@Slf4j
public class bots_Test {

    Slack slack = Slack.getInstance(SlackTestConfig.get());

    @Test
    public void botsInfoError() throws IOException, SlackApiException {
        BotsInfoResponse response = slack.methods().botsInfo(req -> req);
        assertThat(response.getError(), is(notNullValue()));
        assertThat(response.isOk(), is(false));
    }

    @Test
    public void botsInfo() throws IOException, SlackApiException {
        String token = System.getenv(Constants.SLACK_SDK_TEST_USER_TOKEN);

        List<User> users = slack.methods().usersList(req -> req.token(token)).getMembers();
        User user = null;
        for (User u : users) {
            if (u.isBot() && !"USLACKBOT".equals(u.getId())) {
                user = u;
                break;
            }
        }
        String bot = user.getProfile().getBotId();

        BotsInfoResponse response = slack.methods().botsInfo(req -> req.token(token).bot(bot));
        assertThat(response.getError(), is(nullValue()));
        assertThat(response.isOk(), is(true));
        assertThat(response.getBot(), is(notNullValue()));
    }

}
