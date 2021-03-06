package com.slack.api.model.block.element;

import com.slack.api.model.block.composition.ConfirmationDialogObject;
import com.slack.api.model.block.composition.PlainTextObject;
import lombok.*;

import java.util.List;

/**
 * https://api.slack.com/reference/block-kit/block-elements#multi_select
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MultiUsersSelectElement extends BlockElement {
    public static final String TYPE = "multi_users_select";
    private final String type = TYPE;
    private String fallback;

    private PlainTextObject placeholder;
    private String actionId;
    private List<String> initialUsers;
    private ConfirmationDialogObject confirm;
    private Integer maxSelectedItems;
}
