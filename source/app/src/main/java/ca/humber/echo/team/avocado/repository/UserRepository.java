package ca.humber.echo.team.avocado.repository;

import android.app.Application;
import android.os.AsyncTask;

import ca.humber.echo.team.avocado.database.AppDataBase;
import ca.humber.echo.team.avocado.database.Entity.User;
import ca.humber.echo.team.avocado.database.dao.UserDao;

public class UserRepository {

    private UserDao userDAO;

    public UserRepository(Application application){
        AppDataBase appDataBase = AppDataBase.getInstance(application);
        userDAO = appDataBase.userDAO();
    }

    public void insert(User user){
        new UserRepository.InsertAsyncTask(userDAO).execute(user);
    }

    /**
     * Starts an asynchronous thread to save a data away from the main thread.
     */
    private static class InsertAsyncTask extends AsyncTask<User, Void, Void> {

        private UserDao mAsyncTaskDao;

        InsertAsyncTask(UserDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final User... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;

        }
    }
}
