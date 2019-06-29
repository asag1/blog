import React from "react";
import "./App.css";
import Post from "./components/Post";

const post = [
  {
    title: "Trip to Japan",
    date: "2019-06-28",
    text:
      "In Japan the food can be described as clean and minimalist, but never simple, which probably sums up Japan as a whole.  It’s a place that both lives up to, and out does, any expectation you have upon arrival."
  },
  {
    title: "Trip to Turkey",
    date: "2019-05-20",
    text:
      "Turkey is a country full of contrasts: imposing mountain ranges and fertile plains, lively bathing houses and deserted picturesque beaches, rapidly growing cities and sleepy villages."
  }
];
function App() {
  return (
    <div className="App">
      <div className="topLine">
        <div className="login-container">
          <form>
            <input
              className="Search-box"
              type="search"
              placeholder="SearchBox"
              name="Search"
            />
            <input
              className="Username-input"
              type="text"
              placeholder="Username"
              name="username"
            />
            <input
              className="Pasword-input"
              type="password"
              placeholder="Password"
              name="pasword"
            />
            <button className="Button-login">Login</button>
          </form>
        </div>
      </div>
      <h1 className="Header">Step by step</h1>
      <main className="App-header">
        <div className="Post">
          <Post item={post} />
        </div>
      </main>
    </div>
  );
}

export default App;
