package ru.stqa.pft.rest;


import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.message.BasicNameValuePair;
import org.testng.SkipException;

import java.io.IOException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

    public class TestBase {


        protected Set<Issue> getIssue() throws IOException {
            String json = getExecutor().execute(Request.Get("http://bugify.stqa.ru/api/issues.json")).returnContent().asString();
            JsonElement parsed = new JsonParser().parse(json);
            JsonElement issues = parsed.getAsJsonObject().get("issues");
            return new Gson().fromJson(issues, new TypeToken<Set<Issue>>() {}.getType());
        }

        private Executor getExecutor() {
            return Executor.newInstance().auth("288f44776e7bec4bf44fdfeb1e646490", "");
        }

        protected int createIssue(Issue newIssue) throws IOException {
            String json = getExecutor().execute(Request.Post("http://bugify.stqa.ru/api/issues.json")
                    .bodyForm(new BasicNameValuePair("subject", newIssue.getSubject()),
                            new BasicNameValuePair("description", newIssue.getDescription())))
                    .returnContent().asString();
            JsonElement parsed = new JsonParser().parse(json);
            return parsed.getAsJsonObject().get("issue_is").getAsInt();
        }

        public void skipIfNotFixed (int issueId) throws IOException {
            if (isIssueOpen(issueId)) {
                throw new SkipException("Ignored because of issue " + issueId);
            }
        }

        boolean isIssueOpen(int issueId) throws IOException {

            String url = "http://bugify.stqa.ru/api/issues/" + issueId + ".json";
            String json = getExecutor().execute(Request.Get(url)).returnContent().asString();
            JsonElement parsed = new JsonParser().parse(json);
            JsonArray array = parsed.getAsJsonObject().get("issues").getAsJsonArray();

            if (array.size() != 1) {
                throw new IllegalArgumentException("Return more that 1 issue");
            }

            JsonElement elm = array.get(0);
            JsonElement state = elm.getAsJsonObject().get("state");
            String stringState = state.toString().replaceAll("^\"|\"$", "");

            if (stringState.equals("3")) {
                return false;
            } return true;
        }


    }
