package finalmission.service;

import java.util.List;

import finalmission.domain.Nickname;
import finalmission.service.dto.NicknameGenerateCondition;

public interface NicknameGenerator {
    List<Nickname> generate(NicknameGenerateCondition condition);
}
