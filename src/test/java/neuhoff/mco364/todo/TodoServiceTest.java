package neuhoff.mco364.todo;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import neuhoff.mco364.ToDoService;
import neuhoff.mco364.Todo;

import org.junit.Test;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TodoServiceTest {

	@Test
	public void testListTodos() throws IOException {
		Retrofit retrofit = new Retrofit.Builder().baseUrl(
				"http://jsonplaceholder.typicode.com")
				.addConverterFactory(GsonConverterFactory.create())
				.build();

		ToDoService service = retrofit.create(ToDoService.class);
		
		Call<List<Todo>> call = service.listTodods();
		
		Response<List<Todo>> response = call.execute();
		List<Todo> list = response.body();
		assertEquals(200, list.size());
		
	}
}
