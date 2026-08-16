function encodeURI_to_RFC3986(input) {
  return input.replace(/%5B/g, "[").replace(/%5D/g, "]");
}
console.log(encodeURI_to_RFC3986(encodeURI(";/?:@&=+$,#A-Z a-z0-9-_.!~*'()[]{}")));
