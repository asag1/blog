import React, { useState } from "react";
import "./index.css";
import { useFetch } from "../../utils/fetch-hook";
import { API_ENDPOINTS } from "../../utils/constants";
import { fetchpost } from "../../utils/post";
import { fetchdelete } from "../../utils/delete";
import { isModuleDeclaration } from "@babel/types";
// import button from "../Botton"


function Post(props) {
  const { loading, data, setData } = useFetch(API_ENDPOINTS.postInfo);
  
  const addPost = post => {
    setData([...data, post]);
  };

  const removePost = postId => {
    setData(data.filter(post => postId !== post.id));
  };

  return (
    <section className="Post">
      {loading ? (
        <div />
      ) : (
        data.map(post => <Item removePost={removePost} data={post} />)
      )}
      <AddPostForm addPost={addPost} />

      {/* {props.item.map(Item)}</section>; */}
    </section>
  );
}

function AddPostForm(props) {
  const initialFormState = { title: "", text: "" };

  const [post, setPost] = useState(initialFormState);

  const handleInputChange = event => {
    const { title, text } = event.target;
   
    setPost({ ...post, [title]: text });
  };

  const { loading, data } = useFetch(API_ENDPOINTS.postInfo);
  // ar sito reikia?

  const creatPost = async event => {
    event.preventDefault();
    if (!post.title || !post.text) return;

    const response = await fetchpost(API_ENDPOINTS.postAdd, post);
    props.addPost(response);
    // setPost(initialFormState);
  };

  const newDate = new Date();

  return (
    <form onSubmit={creatPost}>
      <label className="Form">Title</label>
      <div>
        <input
          className="Input-title"
          type="text"
          value={post.text}
          // nesupratu kodel title cia neveikia
          onChange={handleInputChange}
        />
      </div>
      <div>
        <label className="Form">Text</label>
        <input
          className="Input-text"
          type="text"
          value={post.text}
          onChange={handleInputChange}
          onSubmit={newDate}
          // nezinau ar taip galima data ideti
        />
      </div>
      {loading ? (
        <div>Loading...</div>
      ) : (
        data.map(type => <option value={type}>{type}</option>)
      )}

      <button className="Add-button">Add new Post</button>
    </form>
  );
}

function Item(props) {
  const clicked = async event => {
    event.preventDefault();
    const { title } = event.target;
    console.log(title);

    props.removePost(props.data.id);
    await fetchdelete(API_ENDPOINTS.postDelete, title);
  };

  return (
    <div className="Post--item">
      <a className="Post--item" href={props.data.url}>
        <span className="Post--item-title">{`Title: ${props.title}`}</span>
        <span className="Post--item-text">{props.text}</span>
      </a>
      <button value={props.id} onClick={clicked}>
        Delete
      </button>
      <button value={props.id} onClick={clicked}>
        Update
      </button>
    </div>
  );
}

export default Post;
