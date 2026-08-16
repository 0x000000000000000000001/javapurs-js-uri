function encodeURIComponent_to_RFC3986(input) {
  return input.replace(/[!'()*]/g, function (c) {
    return "%" + c.charCodeAt(0).toString(16).toUpperCase();
  });
}
console.log(encodeURIComponent_to_RFC3986(encodeURIComponent("!'()*-._~")));
