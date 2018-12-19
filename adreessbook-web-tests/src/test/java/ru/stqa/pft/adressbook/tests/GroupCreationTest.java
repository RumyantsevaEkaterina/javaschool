package ru.stqa.pft.adressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.GroupData;


import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTest extends TestBase {


    @Test
    public void testCreateGroup() throws Exception {
        app.goTO().groupPage();
        Set<GroupData> before = app.group().all();
        GroupData group = new GroupData().withName("test2");
        app.group().create(group);
        Set<GroupData> after = app.group().all();
        assertThat(after.size(), equalTo(before.size() + 1));

        group.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt());
        before.add(group);
        assertThat(after, equalTo(before));

    }


}
