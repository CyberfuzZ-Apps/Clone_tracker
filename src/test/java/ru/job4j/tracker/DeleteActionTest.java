package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DeleteActionTest {

    @Test
    public void execute() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        String itemName = "Item for delete";
        tracker.add(new Item(itemName));
        assertThat(tracker.findAll().get(0).getName(), is(itemName));

        DeleteAction deleteAction = new DeleteAction(out);

        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);

        deleteAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Delete item ==="
                + ln
                + "Заявка удалена успешно."
                + ln));
        assertThat(tracker.findAll(), is(List.of()));
    }
}