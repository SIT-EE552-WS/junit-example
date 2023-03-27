package edu.stevens.friccobo;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;

class MyListTest {
    // can I add to a list?
    // can I remove from a list?
    // -- what happens if the list is empty?
    // can I get an element at a certain position
    // -- what happens if there is no element at that position?

    MyList<Integer> integers;

    @BeforeAll
    static void setup(){
        System.out.println("before ALL");
    }

    @AfterAll
    static void teardown(){
        System.out.println("after ALL");
    }

    @BeforeEach
    void setupList(){
        integers =  new MyList<>();
    }

    @AfterEach
    void cleanup(){
        System.out.println("we're done");
    }

    @Test
    @DisplayName("can add to a list")
    void testAddToList(){
        integers.add(5);
        assertEquals(1, integers.size());
    }

    @ParameterizedTest(name = "can add {0} to a list")
    @CsvSource({
            "1",
            "2",
            "3",
            "4"
    })
    void testAddManyToList(int number){
        integers.add(number);
        assertEquals(1, integers.size());
    }

    @Test
    void testRemoveFromList(){
        integers.add(1);
        integers.add(5);
        integers.add(6);
        integers.remove(5);
        assertEquals(2, integers.size());
        assertEquals(6, integers.get(1));
    }

    @Test
    void testRemoveFromEmptyList(){
        integers.remove(5);
        assertEquals(0, integers.size());
    }

    @Test
    void testGetElement(){
        integers.add(1);
        integers.add(5);
        integers.add(7);
        assertThat(integers.get(0), equalTo(1));
    }

    @Test
    void testClear(){
        integers.add(1);
        integers.add(5);
        integers.add(7);
        integers.clear();
        assertThat(integers, hasSize(0));
    }

    @Test
    void testGetInvalidElement(){
        integers.add(1);
        integers.add(5);
        integers.add(7);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            integers.get(5);
        });
    }
}