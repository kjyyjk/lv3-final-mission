package finalmission.service;

import java.util.List;

import org.springframework.stereotype.Service;

import finalmission.domain.Nickname;
import finalmission.service.dto.NicknameGenerateCondition;

@Service
public class NicknameService {

    private final NicknameGenerator nicknameGenerator;

    public NicknameService(NicknameGenerator nicknameGenerator) {
        this.nicknameGenerator = nicknameGenerator;
    }

    public List<Nickname> recommend(NicknameGenerateCondition condition) {
        return nicknameGenerator.generate(condition);
    }
}
