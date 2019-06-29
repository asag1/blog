import { API_DOMAIN } from "./constants";

export const fetchdelete = async (url, id) => {
  return fetch(`${API_DOMAIN}${url}/${id}`, {
    method: "delete"
  });
};
