package com.slack.api.scim.response;

import com.slack.api.scim.SCIMApiResponse;
import com.slack.api.scim.model.User;
import lombok.Data;

@Data
public class UsersReadResponse extends User implements SCIMApiResponse {
}
