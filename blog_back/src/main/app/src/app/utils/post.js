import { API_DOMAIN } from "./constants";

export const fetchpost = (url, request) => {
  return fetch(`${API_DOMAIN}${url}`, {
    body: JSON.stringify(request),
    method: "POST",
    headers: { Accept: "application/json", "Content-type": "application/json" }
  }).then(resp => resp.json());
};
