package ru.job4j.question;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Objects;

public class Analize {
    public static Info diff(Set<User> previous, Set<User> current) {
        int added = 0;
        int changed = 0;
        Map<Integer, String> prevMap = previous.stream()
                .collect(Collectors.toMap(User::getId, User::getName));
        for (User user : current) {
            if (!prevMap.containsKey(user.getId())) {
                added++;
            } else if (!Objects.equals(prevMap.get(user.getId()), (user.getName()))) {
                changed++;
            }
        }
        int deleted = previous.size() + added - current.size();
        return new Info(added, changed, deleted);
    }
}
