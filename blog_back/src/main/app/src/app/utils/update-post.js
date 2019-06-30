

 return fetch(`${API_DOMAIN}${url}`, {
    body: JSON.stringify(request),
    method: "PUT",
    headers: { Accept: "application/json", "Content-type": "application/json" }
  }).then(resp => resp.json());
 };