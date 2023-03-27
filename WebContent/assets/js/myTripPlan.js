/**
 * 
 */
let li = new Set();
const addMyTrip = (place, idx) => {
  // console.log(idx, place);
  li.add(place);
  console.log(idx);
  var listEl = document.getElementById("tripList");

  var el = document.createElement("li"),
    itemStr =
      '<span class="markerbg marker_' +
      idx +
      '"></span>' +
      '<div class="info">' +
      "   <h5>" +
      place.place_name +
      "</h5>";

  if (place.road_address_name) {
    itemStr +=
      "    <span>" +
      place.road_address_name +
      "</span>" +
      '   <span class="jibun gray">' +
      place.address_name +
      "</span>";
  } else {
    itemStr += "    <span>" + place.address_name + "</span>";
  }

  el.innerHTML = itemStr;
  el.className = "item";
  listEl.appendChild(el);
  // return el;
};
