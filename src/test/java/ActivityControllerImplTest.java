import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.example.bibliotheque.controller.ActivityControllerImpl;
import org.example.bibliotheque.model.Activity;
import org.example.bibliotheque.repository.ActivityRepositoryImpl;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;
import java.util.Optional;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

@ExtendWith(MockitoExtension.class)
@DisplayName("Group of units tests for the activity controller")
public class ActivityControllerImplTest {

    @Mock
    ActivityRepositoryImpl activityRepository;

    Activity runningActivity = new Activity(
            "idRunning",
            "Running",
            30,
            new Date(),
            5,
            150);

    ActivityControllerImpl classUnderTest;

    @BeforeEach
    public void setUp () {
        classUnderTest = new ActivityControllerImpl(activityRepository);
    }



    @Test
    @DisplayName("Test if the get method of the repository is called with an id")
    public void get_withId_shouldCallRepository () {
        // Arrange
        when(activityRepository.findOne(runningActivity.getId())).thenReturn(Optional.of(runningActivity));

        // Act
        Optional<Activity> result = classUnderTest.getActivity(runningActivity.getId());

        // Assert
        verify(activityRepository).findOne(runningActivity.getId());
        assertThat(result).isNotEmpty();
        assertThat(result.get()).isEqualTo(runningActivity);
    }

    @Test
    @DisplayName("Test if the update method of the repository is called with an id and an Activity")
    public void update_withIdAndActivity_shouldCallRepository () {
        // Arrange
        UpdateResult mockUpdateResult = mock(UpdateResult.class); // Create a mock UpdateResult
        when(activityRepository.update(runningActivity.getId(), runningActivity)).thenReturn(mockUpdateResult);

        // Act
        UpdateResult result = classUnderTest.updateActivity(runningActivity.getId(), runningActivity);

        // Assert
        verify(activityRepository).update(runningActivity.getId(), runningActivity);
        assertThat(result).isEqualTo(mockUpdateResult);
    }

    @Test
    @DisplayName("Test if the create method of the repository is called with an activity")
    public void create_withActivity_shouldCallRepository() {
        // Arrange
        Activity activity = new Activity("","Jumping", 90, new Date(), 8, 20); // create an Activity instance with your required fields
        when(activityRepository.save(any(Activity.class))).thenReturn(String.valueOf(activity));

        // Act
        String result = classUnderTest.saveActivity(activity);

        // Assert
        verify(activityRepository).save(activity);
        assertThat(result).isEqualTo(activity.toString());
    }

    @Test
    @DisplayName("Test if the getAll method of the repository is called")
    public void getAll_shouldCallRepository() {
        // Arrange
        List<Activity> activities = new ArrayList<>(); // add activities to the list if required
        when(activityRepository.findAll()).thenReturn(activities);

        // Act
        List<Activity> result = classUnderTest.getAllActivities();

        // Assert
        verify(activityRepository).findAll();
        assertThat(result).isEqualTo(activities);
    }


    @Test
    @DisplayName("Test if the delete method of the repository is called with an id")
    public void delete_withId_shouldCallRepository () {
        // Arrange
        DeleteResult mockDeleteResult = mock(DeleteResult.class); // Create a mock DeleteResult
        when(mockDeleteResult.getDeletedCount()).thenReturn(1L); // Setup mock to return 1 deleted document
        when(activityRepository.delete(runningActivity.getId())).thenReturn(mockDeleteResult);

        // Act
        DeleteResult result = classUnderTest.deleteActivity(runningActivity.getId());

        // Assert
        verify(activityRepository).delete(runningActivity.getId());
        assertThat(result.getDeletedCount()).isEqualTo(1L); // Assert that one document was deleted
    }

}