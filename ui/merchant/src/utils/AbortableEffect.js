import {useEffect} from "react";

export default function useAbortableEffect(effect, dependencies) {
  const status = {}; // mutable status object
  useEffect(() => {
    status.aborted = false;
    // store the returned value for cleanup
    const cleanUpFn = effect(status);
    return () => {
      // this effect is cleaning up
      status.aborted = true;
      if (typeof cleanUpFn === "function") {
        // run the cleanup function
        cleanUpFn();
      }
    };
  }, [...dependencies]);
}
export function execute(status, promise, callback) {
  if (promise.then) {
    promise.then((res) => {
      if (!status.aborted && callback) {
        callback(res);
      }
    });
  } else {
    if (!status.aborted && callback) {
      callback();
    }
  }
}
