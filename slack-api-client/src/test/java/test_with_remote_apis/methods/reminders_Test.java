package test_with_remote_apis.methods;

import com.slack.api.Slack;
import com.slack.api.methods.response.reminders.RemindersAddResponse;
import com.slack.api.methods.response.reminders.RemindersCompleteResponse;
import com.slack.api.methods.response.reminders.RemindersDeleteResponse;
import com.slack.api.methods.response.reminders.RemindersInfoResponse;
import config.Constants;
import config.SlackTestConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@Slf4j
public class reminders_Test {

    Slack slack = Slack.getInstance(SlackTestConfig.get());
    String token = System.getenv(Constants.SLACK_SDK_TEST_USER_TOKEN);

    @Test
    public void test() throws Exception {
        RemindersAddResponse addResponse = slack.methods().remindersAdd(r -> r
                .token(token)
                .text("Don't forget it!")
                .time("10"));
        assertThat(addResponse.getError(), is(nullValue()));
        assertThat(addResponse.isOk(), is(true));

        String reminderId = addResponse.getReminder().getId();

        RemindersInfoResponse infoResponse = slack.methods().remindersInfo(r -> r
                .token(token)
                .reminder(reminderId));
        assertThat(infoResponse.getError(), is(nullValue()));
        assertThat(infoResponse.isOk(), is(true));

        RemindersCompleteResponse completeResponse = slack.methods().remindersComplete(r -> r
                .token(token)
                .reminder(reminderId));
        assertThat(completeResponse.getError(), is(nullValue()));
        assertThat(completeResponse.isOk(), is(true));

        RemindersDeleteResponse deleteResponse = slack.methods().remindersDelete(r -> r
                .token(token)
                .reminder(reminderId));
        assertThat(deleteResponse.getError(), is(nullValue()));
        assertThat(deleteResponse.isOk(), is(true));
    }

}
